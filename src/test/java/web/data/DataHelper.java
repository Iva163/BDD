package web.data;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DataHelper {

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class CardInfo {
        String card1;
        String card2;
    }

    public static CardInfo getCardNumber() {
        return new CardInfo("5559 0000 0000 0001", "5559 0000 0000 0002");
    }


}
