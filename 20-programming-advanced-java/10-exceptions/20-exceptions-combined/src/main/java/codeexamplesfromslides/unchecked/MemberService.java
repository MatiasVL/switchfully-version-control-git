package codeexamplesfromslides.unchecked;

public class MemberService {

    public static void main(String[] args) {
        MemberService service = new MemberService();
        try {
            Member member = service.createMember("jim@jimmy.be");
            System.out.println(member);
        } catch(IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }

    public Member createMember(String email) throws IllegalArgumentException {
        if (!validEmail(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
        return new Member(email);
    }

    private boolean validEmail(String email) {
        return false;
    }

    private class Member {
        public Member(String email) {
        }
    }
}
