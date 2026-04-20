import Course.Status;

public class Main {

    public static void main(String[] args) {
        Course javaCourse;

        javaCourse = new Course();

        javaCourse.id=1L;
        javaCourse.title = "자바 입문";
        javaCourse.description = "프로그래밍 초심자를 위한 강좌";
        javaCourse.status = Status.DRAFT;

        System.out.println(javaCourse.title);
        System.out.println(javaCourse.status);
    }

}
