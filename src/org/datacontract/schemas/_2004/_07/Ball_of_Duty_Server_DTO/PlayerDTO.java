/**
 * PlayerDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Ball_of_Duty_Server_DTO;

public class PlayerDTO  implements java.io.Serializable {
    private int characterId;

    private int gold;

    private double highScore;

    private int id;

    private java.lang.String nickname;

    public PlayerDTO() {
    }

    public PlayerDTO(
           int characterId,
           int gold,
           double highScore,
           int id,
           java.lang.String nickname) {
           this.characterId = characterId;
           this.gold = gold;
           this.highScore = highScore;
           this.id = id;
           this.nickname = nickname;
    }


    /**
     * Gets the characterId value for this PlayerDTO.
     * 
     * @return characterId
     */
    public int getCharacterId() {
        return characterId;
    }


    /**
     * Sets the characterId value for this PlayerDTO.
     * 
     * @param characterId
     */
    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }


    /**
     * Gets the gold value for this PlayerDTO.
     * 
     * @return gold
     */
    public int getGold() {
        return gold;
    }


    /**
     * Sets the gold value for this PlayerDTO.
     * 
     * @param gold
     */
    public void setGold(int gold) {
        this.gold = gold;
    }


    /**
     * Gets the highScore value for this PlayerDTO.
     * 
     * @return highScore
     */
    public double getHighScore() {
        return highScore;
    }


    /**
     * Sets the highScore value for this PlayerDTO.
     * 
     * @param highScore
     */
    public void setHighScore(double highScore) {
        this.highScore = highScore;
    }


    /**
     * Gets the id value for this PlayerDTO.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this PlayerDTO.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the nickname value for this PlayerDTO.
     * 
     * @return nickname
     */
    public java.lang.String getNickname() {
        return nickname;
    }


    /**
     * Sets the nickname value for this PlayerDTO.
     * 
     * @param nickname
     */
    public void setNickname(java.lang.String nickname) {
        this.nickname = nickname;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PlayerDTO)) return false;
        PlayerDTO other = (PlayerDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.characterId == other.getCharacterId() &&
            this.gold == other.getGold() &&
            this.highScore == other.getHighScore() &&
            this.id == other.getId() &&
            ((this.nickname==null && other.getNickname()==null) || 
             (this.nickname!=null &&
              this.nickname.equals(other.getNickname())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getCharacterId();
        _hashCode += getGold();
        _hashCode += new Double(getHighScore()).hashCode();
        _hashCode += getId();
        if (getNickname() != null) {
            _hashCode += getNickname().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PlayerDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Ball_of_Duty_Server.DTO", "PlayerDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("characterId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Ball_of_Duty_Server.DTO", "CharacterId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gold");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Ball_of_Duty_Server.DTO", "Gold"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("highScore");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Ball_of_Duty_Server.DTO", "HighScore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Ball_of_Duty_Server.DTO", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nickname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Ball_of_Duty_Server.DTO", "Nickname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
