//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    IO.println(String.format("Hello and welcome!"));

    Student stu = new Student("이순신", "mjc928319", Major.InfoTelecom);

    TransJson tj = new TransJson();
    String strJson = tj.toJsonString(stu);
    System.out.println(strJson);

    Student res = (Student) tj.toObject(strJson, Student.class);
    if (res instanceof Student stu2) {
        System.out.println(stu2);
    }
    System.out.println(tj.hashCode());
    System.out.println(res.hashCode());
}
