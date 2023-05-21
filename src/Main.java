public class Main {
    private static final String VALIDATE_PATTERN = "^[a-zA-Z0-9-_]+$";
    public static void main(String[] args) {
        check("login","password","password");
        check("login","password/","password");
        check("login","passwordpasswordpasswordpassword","password");
        check("loginloginloginloginlogin","password","password");
    }

    private static void check(String login, String password, String repeatPassword) {
        try {
            checkLogin(login);
            checkPassword(password, repeatPassword);
        } catch (WrongLoginException e) {
            e.printStackTrace();
        } catch (WrongPasswordException e) {
            e.printStackTrace();
        }
    }

    private static void checkLogin(String login) throws WrongLoginException{
        if (!login.matches(VALIDATE_PATTERN)) {
            throw new WrongLoginException("Ошибка! Логин должен содержать в себе только латинские буквы, цифры и знак подчеркивания");
        } else if (login.length() > 20) {
            throw new WrongLoginException("Ошибка! Длина логина не должна превышать 20 символов");
        }
    }

    private static void checkPassword(String password, String repeatPassword) throws WrongPasswordException{
        if (!password.matches(VALIDATE_PATTERN)) {
            throw new WrongPasswordException("Ошибка! Пароль должен содержать в себе только латинские буквы, цифры и знак подчеркивания");
        } else if (password.length() > 20) {
            throw new WrongPasswordException("Ошибка! Длина пароля не должна превышать 20 символов");
        } else if (!password.equals(repeatPassword)) {
            throw new WrongPasswordException("Ошибка! Пароли не совпадают");
        }
    }
}