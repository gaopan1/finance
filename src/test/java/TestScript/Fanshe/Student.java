package TestScript.Fanshe;

public class Student {

	Student(String str) {
		System.out.println("默认的构造方法 s = " + str);
	}

	public Student() {
		System.out.println("调用了公有  无参数构造方法执行了。。。。");
	}

	public Student(char name) {
		System.out.println("姓名：" + name);
	}

	public Student(String name, int age) {
		System.out.println("姓名：" + name + "年龄 ：" + age);
	}

	protected Student(boolean n) {
		System.out.println("受保护的构造方法  n = " + n);
	}

	private Student(int age) {
		System.out.println("私有的构造方法   年龄：" + age);
	}
	

	public String name;
	
	public int age;
	
	private String sex;
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public static void play(){
		System.out.println("Student play~~~~~~~");
	}
	
	public void play(String place){
		System.out.println("student play in " + place);
	}
	
	
	
	
	

}
