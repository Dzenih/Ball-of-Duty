package application.communication;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.xml.rpc.ServiceException;

import org.datacontract.schemas._2004._07.Ball_of_Duty_Server_DTO.AccountDTO;
import org.datacontract.schemas._2004._07.Ball_of_Duty_Server_DTO.GameDTO;
import org.datacontract.schemas._2004._07.Ball_of_Duty_Server_DTO.PlayerDTO;
import org.tempuri.BoDServiceLocator;
import org.tempuri.IBoDService;

import application.account.Account;
import application.account.Player;
import application.engine.entities.BoDCharacter;
import application.engine.game_object.GameObject;
import application.engine.rendering.ClientMap;
import application.gui.Leaderboard;
import application.input.CharacterController;
import javafx.geometry.Point2D;
import javafx.scene.layout.BorderPane;

/**
 * Communicates with the server via webservices and is the main facade for a
 * game.
 * 
 * @author Gruppe6
 *
 */
public class GameClient
{

    public ClientMap cMap;
    public Player clientPlayer;
    public Account account;
    public CharacterController characterController;
    public Point2D sceneRelativeLocation;
    IBoDService ibs;
    private Leaderboard leaderboard;
    public ConcurrentMap<Integer, GameObject> gameObjects;

    /**
     * Creates a game client with the current relative location of the window.
     * The relative location is based on how the scene's is located relative to
     * the operating system.
     * 
     * @param windowRelativeLocation
     *            The current relative location of the window. The relative
     *            location is based on how the scene's is located relative to
     *            the operating system,
     */
    public GameClient(Point2D windowRelativeLocation)
    {

        this.sceneRelativeLocation = windowRelativeLocation;
        this.leaderboard = new Leaderboard();
        BoDServiceLocator server1 = new BoDServiceLocator();
        gameObjects = new ConcurrentHashMap<>();

        try
        {
            ibs = server1.getBasicHttpBinding_IBoDService();

        }
        catch (ServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    public void getLeaderboard(BorderPane lbBorder){
//        for (PlayerDTO pdto : serverGame.getPlayers())
//        {
//            BoDCharacter character = (BoDCharacter)gameObjects.get(pdto.getCharacterId());
//            if (character == null)
//            {
//                continue;
//            }
//            character.setNickname(pdto.getNickname());
//            leaderboard.addCharacter(character);
//        }
        
        
        lbBorder.setCenter(leaderboard);
        
        
    }

    public void joinAsGuest(BorderPane gameBox, String nickname)
    {
        try
        {
            clientPlayer = new Player(ibs.newGuest(nickname));
            joinGame(gameBox);
        }
        catch (RemoteException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void createAccount(String username, String nickname, char[] password, char[] passwordConfirmation)
    {
        for (int i = 0; i < password.length; i++)
        {
            if (password[i] != passwordConfirmation[i])
            {
                throw new IllegalArgumentException("Password not correct");
            }
        }

        account = new Account(username, password);
        int id = 0;

        if (clientPlayer != null)
        {
            id = clientPlayer.getId();
        }
        try
        {
            AccountDTO verifiedAccount = ibs.newAccount(username, nickname, id, account.getSalt(), account.getHash());
            if (verifiedAccount.getId() != 0)
            {
                System.out.println("Account created, with id: " + verifiedAccount.getId());
            }
            else
            {
                System.out.println("Error!");
            }
        }
        catch (RemoteException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Sets the scenes relative location. The relative location is based on how
     * the scene's is located relative to the operating system.
     * 
     * @param sceneRelativeLocation
     *            The scenes relative location. he relative location is based on
     *            how the scene's is located relative to the operating system.
     */
    public void setSceneRelativeLocation(Point2D sceneRelativeLocation)
    {
        this.sceneRelativeLocation = sceneRelativeLocation;
        if (characterController != null)
        {
            characterController.setCanvasRelativeLocation(sceneRelativeLocation);
        }

    }

    /**
     * Tries to join a game. The game graphics and UI is handled in a BorderPane
     * called game box.
     * 
     * @param gameBox
     *            The BorderPane where the game graphics and UI is handled.
     */
    private void joinGame(BorderPane gameBox)
    {
        System.out.println("trying to join game");
        try
        {
            Broker broker = new Broker();
            GameDTO map = ibs.joinGame(clientPlayer.getId(), broker.getUdpPort(), broker.getTcpPort(), 1); // TODO
                                                                                                           // dynamic
                                                                                                           // character
                                                                                                           // creation
            clientPlayer.createNewCharacter(map.getCharacterId());
            cMap = new ClientMap(map, gameBox, broker, clientPlayer.getCharacter());

        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }

        characterController = new CharacterController(clientPlayer.getCharacter(), gameBox, sceneRelativeLocation);
        cMap.activate();

    }

    /**
     * Tries to quit the current game.
     */
    public void quitGame()
    {
        try
        {
            if (ibs != null && clientPlayer != null)
            {
                ibs.quitGame(clientPlayer.getId());
            }

        }
        catch (RemoteException e)
        {
            System.out.println("I was unable to quit the game " + e);
            e.printStackTrace();
        }
        if (cMap != null)
        {
            cMap.deactivate();
        }

        // cMap = null;
    }

    /**
     * Gets the current CharacterController controlling the client character.
     * 
     * @return Returns the current CharacterController controlling the client
     *         character.
     */
    public CharacterController getCharacterController()
    {
        return characterController;

    }

}
