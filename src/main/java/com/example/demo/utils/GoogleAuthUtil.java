package com.example.demo.utils;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

/**
 * @author: lyc
 * @date: 2020/8/20 13:41
 * @describe
 *https://blog.csdn.net/m0_37202351/article/details/88841969
 *https://www.jianshu.com/p/45d2bb5729d9
 * https://www.zhihu.com/question/20462696
 * https://www.zhihu.com/tardis/landing/360/ans/18731073?query=%E8%B0%B7%E6%AD%8C%E4%BB%A4%E7%89%8C%E7%A7%98%E9%92%A5&mid=77c513b889707a8845ddcbb8dd1c2bff&guid=8F6ADAEEFE1A83C495FCFD99F6F714CE.1595920709978
 */
public class GoogleAuthUtil {
    /**
     * 用一次性密码双重验证
     * 用户双重验证为您的交易密码带来第二重保护。启用这一功能后，在您每次提取现金操作前都必须输入手机应用程序上显示的一次性密码。您可以依照下面的步骤来设置并启用这一功能。本功能目前支持ios和Android设备
     *
     * 第一步：在您手机上下载并安装一次性密码生成程序
     * 1.在您的手机上打开App Store（iOS）或Google Play（Android），或其他软件市场。
     * 2.搜索“Google Authenticator（谷歌身份验证器）”。
     * 3.  下载并安装该应用程序
     *
     * 第二步：安装完成后，对该应用程序进行手动或扫码配置
     * 1.手动配置
     * 在绑定安全令牌页面点击“生成验证码”按钮获取账户及密钥；
     * 在“Google Authenticator（谷歌身份验证器）”应用程序中，点击“添加新账户（iOS下是+号）“->” 手动输入验证码
     * 2.扫码绑定
     * 在“Google Authenticator（谷歌身份验证器）”应用程序中，点击“添加新账户（iOS下是+号）“->” 扫描条形码”。
     * 将手机上的相机镜头对准下图扫描该条形码。
     *
     * 第三步：开启双重验证功能
     * 配置完成后，手机上会显示一个6位数字，每隔30秒变化一次，这个数字即为您的一次性验证码。如果您要开启该功能，请在绑定安全令牌页面输入您当前的双重验证密码完成开启。
     * @param args
     */

    /**
     *  二次验证 步骤
     *  用户是否开启（随机key1）二次验证 开启后绑定二次验证 key1 为用户，
     *  以后 每次登入 操作 用户本地都会 根据 key 生成 随机验证码
     *  后台 验证 验证码 是否正确
     * @param args
     */
    public static void main(String[] args) {

        // 用户注册时使用
        // 获取一个新的密钥，默认16位，该密钥与用户绑定
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        final GoogleAuthenticatorKey key = gAuth.createCredentials();
        String key1 = key.getKey();

        String qrBarcodeURL = getQRBarcodeURL(key1);

        // 用户登录时使用
        // 根据用户密钥和用户输入的密码，验证是否一致。（近3个密码都有效：前一个，当前，下一个）
        boolean isCodeValid = gAuth.authorize(key1, 496969);
        System.out.println(isCodeValid);

        // 根据密钥，获取最新密码（后台用不到，用来开发 谷歌身份验证器 客户端）
        int code = gAuth.getTotpPassword(key1);
        System.out.println(code);
    }


    public static String getQRBarcodeURL(String secret) {
        String format = "otpauth://totp/" + String.valueOf(System.currentTimeMillis()) + "-?secret=" + secret;
        return format;
    }

}
