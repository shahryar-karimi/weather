package ir.shahryar.weather.user;

public class UserValidation {
    private User MainUser;

    public boolean isNull(User user) {
        return user == null;
    }

    public boolean isCorrectPassword(User user, String password) {
        return user.getPassword().equals(password);
    }
}
