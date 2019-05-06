package hashTable_06;

import java.util.Objects;

public class Person {
	String name;
    String sex;
    String bloodType;

    public Person(String name, String sex, String bloodType) {
        this.name = name;
        this.sex = sex;
        this.bloodType = bloodType;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getBloodType() {
        return bloodType;
    }

    @Override
    public String toString() {
        return String.format("Person{%s, %s, %s}", name, sex, bloodType);
    }

	@Override
	public int hashCode() {
		return Objects.hash(name, sex, bloodType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (bloodType == null) {
			if (other.bloodType != null)
				return false;
		} else if (!bloodType.equals(other.bloodType))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}

}
