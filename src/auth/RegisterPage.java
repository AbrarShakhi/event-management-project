package auth;

public class RegisterPage implements Auth {
    private boolean isValidUser;

    @Override
    public boolean isSuccess() {
        return isValidUser;
    }

    private RegisterPage(){

        // it will be true for new. When we make it functional it will be false for default. 
        // user have match user name and password to make it true;
        isValidUser = true;
    }
}
