package domain;

public class Employee {

	/* Data members */

	private Integer empId;
	private String empFirstName;
	private String empLastName;

	/* Default Constructor */

	public Employee() {
		super();
	}

	/* Parameterised Constructor */

	public Employee(Integer empId, String empFirstName, String empLastName) {
		super();
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
	}

	/*------------------------------------------------------*/

	/* hash code method */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((empFirstName == null) ? 0 : empFirstName.hashCode());
		result = prime * result + ((empLastName == null) ? 0 : empLastName.hashCode());
		return result;
	}

	/*------------------------------------------------------*/

	/* equals method */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (empFirstName == null) {
			if (other.empFirstName != null)
				return false;
		} else if (!empFirstName.equals(other.empFirstName))
			return false;
		if (empLastName == null) {
			if (other.empLastName != null)
				return false;
		} else if (!empLastName.equals(other.empLastName))
			return false;
		return true;
	}

	/*------------------------------------------------------*/

	/* getter and setter method */

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	/*------------------------------------------------------*/

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", hashCode()=" + hashCode() + ", getEmpId()=" + getEmpId() + ", getEmpFirstName()="
				+ getEmpFirstName() + ", getEmpLastName()=" + getEmpLastName() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}

}
