package spring;
import java.time.LocalDateTime;
public class MemberRegisterService {
    private MemberDao memberDao;

    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public Long regist(RegisterRequest req) {
        Member member = memberDao.selectByEmail(req.getEmail());
        if (member != null) { // 이미 존재한다면,
            throw new DuplicateMemberException("Email 중복");
        }
        Member newMember = new Member(
                req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now()
        );
        memberDao.insert(newMember);
        return newMember.getId();
    }
}
