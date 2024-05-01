package in.nitj.tpo.exception;

public class JwtTokenExpiredException extends RuntimeException{
    public JwtTokenExpiredException(String message) {
        super(message);
    }
}
