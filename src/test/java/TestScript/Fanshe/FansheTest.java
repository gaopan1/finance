package TestScript.Fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class FansheTest {

	@Test
	public void test11() throws Exception {

		changeFieldValue("TestScript.Fanshe.Student", "name", "zhagnsan",
				"getName");

	}

	public void changeFieldValue(String className, String fieldName,
			String value, String methodName) throws Exception {

		Class clazz = Class.forName(className);

		Object obj = clazz.newInstance();

		Field fd = clazz.getDeclaredField(fieldName);

		fd.setAccessible(true);

		fd.set(obj, value);

		Method me = clazz.getDeclaredMethod(methodName, null);

		Object object = me.invoke(obj, null);

		System.out.println(object);

	}

	public void invokeMethod(Object obj, String methodName, Object[] args)
			throws Exception {

		Class clazz = obj.getClass();

		Method me = clazz.getDeclaredMethod(methodName, null);

		me.invoke(obj, args);

	}

	public void invokeMethod(String className, String methodName,
			Object... args) throws Exception {

		Class clazz = Class.forName(className);

		Object obj = clazz.newInstance();

		Method me = clazz.getMethod(methodName, String.class);

		me.invoke(obj, args);

	}

	@Test
	public void test10() throws Exception {

		invokeMethod("TestScript.Fanshe.Student", "play", "NEW YORK");

	}

	@Test
	public void test9() throws Exception {

		Class clazz = Class.forName("TestScript.Fanshe.Student");

		Constructor con = clazz.getDeclaredConstructor(String.class, int.class);

		Object obj = con.newInstance("zhangsan", 10);

		Method me = clazz.getMethod("play", String.class);

		me.invoke(obj, " beijing");

		// Method me = clazz.getMethod("play", null);
		//
		// Object obj = clazz.newInstance();

		// me.invoke(obj, null);

		// Method me = clazz.getMethod("play", String.class);

		// Object obj = clazz.newInstance();

		// clazz.

		// me.invoke(obj, "青岛");

	}

	@Test
	public void test8() throws Exception {

		Class clazz = Class.forName("TestScript.Fanshe.Student");

		Field[] fds = clazz.getFields();

		for (Field ff : fds) {
			System.out.println(ff);
		}

	}

	@Test
	public void test7() throws Exception {

		Class clazz = Class.forName("TestScript.Fanshe.Student");

		Field[] fds = clazz.getFields();

		for (Field ff : fds) {
			System.out.println(ff);
		}

	}

	@Test
	public void test6() throws Exception {

		Class clazz = Class.forName("TestScript.Fanshe.Student");

		// 获取所有的构造方法

		Constructor cons = clazz.getDeclaredConstructor(int.class);

		System.out.println(cons);

	}

	@Test
	public void test5() throws Exception {

		Class clazz = Class.forName("TestScript.Fanshe.Student");

		// 获取所有的构造方法

		Constructor cons = clazz.getConstructor(String.class, int.class);

		System.out.println(cons);

	}

	@Test
	public void test4() throws Exception {

		Class clazz = Class.forName("TestScript.Fanshe.Student");

		// 获取所有的构造方法

		Constructor cons = clazz.getConstructor(char.class);

		System.out.println(cons);

	}

	@Test
	public void test3() throws Exception {

		Class clazz = Class.forName("TestScript.Fanshe.Student");

		// 获取所有的构造方法

		Constructor cons = clazz.getConstructor(null);

		System.out.println(cons);

	}

	@Test
	public void test2() throws Exception {

		Class clazz = Class.forName("TestScript.Fanshe.Student");

		// 获取所有的构造方法

		Constructor<Student>[] cons = clazz.getDeclaredConstructors();

		for (Constructor<Student> con : cons) {
			System.out.println(con);
		}
	}

	@Test
	public void test1() throws Exception {

		Class clazz = Class.forName("TestScript.Fanshe.Student");

		// 获取所有的公有的构造方法

		Constructor<Student>[] cons = clazz.getConstructors();

		for (Constructor<Student> con : cons) {
			System.out.println(con);
		}
	}

	@Test
	public void test() throws Exception {

		Student stu = new Student();

		Class clazz = stu.getClass();

		Class clazz1 = Student.class;

		Class clazz2 = Class.forName("TestScript.Fanshe.Student");

		assert clazz != clazz1 : "clazz clazz1 not equal";

		assert clazz1 == clazz2 : "clazz1 clazz2 not equal";

	}

}
