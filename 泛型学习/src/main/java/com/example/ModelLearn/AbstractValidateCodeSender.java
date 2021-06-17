package com.example.ModelLearn;

/**
 * 验证码发送器
 */
public abstract class AbstractValidateCodeSender {

    /**
     * 生成并发送验证码
     */
    public void sendValidateCode() {
        // 1.生成验证码
        String code = generateValidateCode();

        // 2.把验证码存入Session
        // ....

        // 3.发送验证码
        sendCode();
    }

    /**
     * 具体发送逻辑，留给子类实现：发送邮件、或发送短信都行
     */
    protected abstract void sendCode();

    /**
     * 生成验证码
     *
     * @return
     */
    public String generateValidateCode() {
        return "123456";
    }

}
