package com.apimarvel.core

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Hash {
    companion object{
        val ts= Timestamp(System.currentTimeMillis()).toString()
        val API_KEY="1199da8b8dfeec18f343f89b62f8e81c"
        val PRIVATE_KEY="bca12ed2dbf9351355d5109fa5411a067157f6d7"
        val hash= BigInteger(1, MessageDigest.getInstance("MD5").digest(
            "$ts$PRIVATE_KEY$API_KEY".toByteArray())).toString(16).padStart(32)
    }
}