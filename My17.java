public class My17
{
	public static void main(String[] args)	
	{
		System.out.println("Welcome to My17 program");	
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Victor Semenovich", 50000);
		Manager m = new Manager("Andrej Petrovich", 50000);
		m.SetBonus(10000);
		staff[1] = m;
		staff[2] = new Employee("Stepan Vlodimirovich", 70000);
		for (int i=0; i<staff.length;i++)	
		{
			Employee e = staff[i];
				System.out.println(" name= "+e.GetName()+" salary=" +e.GetSalary());	
		}
		
		System.out.println("******************************");	
	}	
}

//************************************************************************

 class Employee
{
		private String name;
		private double salary;
		
		public Employee (String name, double salary)
		{
			this.name = name;
			this.salary = salary;
		}
		
		public String GetName()
		{
			return name;
		}
		
		public double GetSalary()
		{
			return salary;
		}		
}

//************************************************************************

class Manager extends Employee
{
	private double bonus;
	
	public Manager(String name, double salary)	
	{
		super(name,salary); bonus = 0;
	}
	
	public void SetBonus(double b)
	{
		bonus = b;
		System.out.println("b="+b);
	}
	
	public double GetSelary()
	{
		double s = super.GetSalary();
		System.out.println("salary+bonus = "+(s+bonus));
		return s+bonus;
	}	
}

