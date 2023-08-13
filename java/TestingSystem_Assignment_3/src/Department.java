import java.util.Comparator;

public class Department implements Comparator<Department> {
	int id;
	String name;

	@Override
	public String toString() {
		return "Department{" + "id=" + id + ", name='" + name + '\'' + '}';
	}

	@Override
	public int compare(Department o1, Department o2) {
		return o1.name.compareTo(o2.name);
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}

		Department department = (Department) o;
		if (name.equals(department.name)) {
			return true;
		}

		return false;
	}

}
