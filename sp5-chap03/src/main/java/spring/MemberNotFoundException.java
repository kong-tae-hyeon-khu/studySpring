package spring;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException() {
        super("해당 계정(member)을 찾을 수 없습니다.");
    }
}
