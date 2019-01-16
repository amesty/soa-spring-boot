package com.example.server.soa.util;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

public class ConfigEncryptUtil {

    /**
     * jasypt 加密
     */
    public static void encrypt() {
        // 加密工具
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        // 加密配置
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        // 自己在用的时候更改此密码
        config.setPassword("123456");
        // 应用配置
        encryptor.setConfig(config);
        // 加密
        System.out.println(encryptor.encrypt("jdbc:mysql://localhost:3306/spring_test?autoReconnect=true&characterEncoding=utf8&useSSL=false"));
        System.out.println(encryptor.encrypt("mysql"));
        System.out.println(encryptor.encrypt("123456"));
    }

    /**
     * jasypt 解密
     */
    public static void decrypt() {
        // 加密工具
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        // 加密配置
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        // 自己在用的时候更改此密码
        config.setPassword("123456");
        // 应用配置
        encryptor.setConfig(config);
        // 解密
        System.out.println(encryptor.decrypt("hHOZ7l413wTq5AanRgSLK1MS7PoUKavDJhKwN4s+3O7MB/422mvEkyiebs3rEd9vdRhYh5xH/oofJy8AsYCnVo0SkHymSHxOKcTt0aPElZSaK/9J96qkDVuM4pKbKZepqwm6B1b8PV8="));
        System.out.println(encryptor.decrypt("Kfhf4HftuSN05fg6HxcWPA=="));
        System.out.println(encryptor.decrypt("RmiqbFUlUfHL/in30mHm6g=="));
    }

    public static void main(String[] args) {
        encrypt();
        decrypt();
    }
}
