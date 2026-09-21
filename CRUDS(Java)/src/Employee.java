import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public abstract class Employee implements Comparable<Employee>
{
	int id;
	String name;
	String post;
	double salary;
	
	public Employee(int id, String name, String post, double salary)
	{
		this.id = id;
		this.name = name;
		this.post = post;
		this.salary = salary;
	}
	
	public void setID()
	{
		this.id =  id;
	}
	
	public void setName()
	{
		this.name =  name;
	}
	
	public void setSalary()
	{
		this.salary =  salary;
	}
	
	public void setPost()
	{
		this.post =  post;
	}
	
//	public int getID()
//	{
//		return this.id =  id;
//	}
//
//	public String getName()
//	{
//		return this.name =  name;
//	}
//	
//	public double getSalary()
//	{
//		return this.salary =  salary;
//	}
//	
//	public String getPost()
//	{
//		return this.post =  post;
//	}
	
	public abstract double calsal();
	
	public int compareTo(Employee t)
    {
		return Integer.compare(this.id, t.id);
    }
	
	public String toString()
	{
		return "\nName : "+name+"\nId : "+id+"\nSalary : "+salary+"\nPost : "+post;
	}
	
}

class HR extends Employee
{	
	double commision;
	
	public HR(int id, String name, String post, double salary, double commision)
	{	
		super(id, name, post, salary);
		this.commision = commision;	
	}
	
	public void setID()
	{
		this.id =  id;
	}
	
	public void setName()
	{
		this.name =  name;
	}
	
	public void setSalary()
	{
		this.salary =  salary;
	}
	
	public void setPost()
	{
		this.post =  post;
	}
	
	public void setCommision()
	{
		this.commision =  commision;
	}
	
	
	public double calsal()
	{
		return this.commision + this.salary;
	}
	
	public String toString()
	{
		return super.toString() + "\nCommision : "+commision+"\nTotal Salary : "+this.calsal();
	}
}

class Admin extends Employee
{	
	double allowance;
	
	public Admin(int id, String name, String post, double salary, double allowance)
	{
		super(id, name, post, salary);
		this.allowance = allowance;
	}
	
	public void setID()
	{
		this.id =  id;
	}
	
	public void setName()
	{
		this.name =  name;
	}
	
	public void setSalary()
	{
		this.salary =  salary;
	}
	
	public void setPost()
	{
		this.post =  post;
	}
	
	public void setAllowance()
	{
		this.allowance =  allowance;
	}
	
	public double calsal()
	{
		return this.allowance + this.salary;
	}
	
	public String toString()
	{
		return super.toString() + "\nAllowance : "+allowance+"\nTotal Salary : "+this.calsal();
	}
}

class Salesmanager extends Employee
{	
	int target;
	double incentive;
	
	public Salesmanager(int id, String name, String post, double salary, int target, double incentive)
	{
		super(id, name, post, salary);
		this.target =target ;
		this.incentive = incentive;
	}
	
	public void setID()
	{
		this.id =  id;
	}
	
	
	public void setName()
	{
		this.name =  name;
	}
	
	public void setSalary()
	{
		this.salary =  salary;
	}
	
	public void setPost()
	{
		this.post =  post;
	}
	
	public void setIncentive()
	{
		this.incentive =  incentive;
	}
	
	public void setTarget()
	{
		this.target = target;
	}
	
	public double calsal()
	{
		return (this.incentive * this.target) + this.salary;
	}
	
	public String toString()
	{
		return super.toString() + "\n Incentives : "+incentive+"\nTarget : "+target+"\nTotal Salary : "+this.calsal();	
	}
}


class operations
{	
	static Scanner scan = new Scanner(System.in);
	
	static LinkedList<Employee> list = new LinkedList<Employee>();
	
	static void Create()
	{
		System.out.println("How amny Employee details you want to Add :");
		int n = scan.nextInt();
		scan.nextLine();
		
		for (int i = 0; i < n; i++) 
		{
			System.out.println("Name :");
			String name = scan.nextLine();
			
			System.out.println("ID :");
			int id = scan.nextInt();
			scan.nextLine();
			
			System.out.println("Salary :");
			double salary = scan.nextDouble();
			scan.nextLine();
			
			System.out.println("Post :");
			String post = scan.nextLine();
			
			for (Employee employee : list) 
			{
				if (id == employee.id) 
				{
					System.out.println("ERROR : Using Duplliacte ID.");
					break;
				}	
			}
			
			switch (post) {
			case "HR":
			{
				System.out.println("Commision : ");
				double commision = scan.nextDouble();
				
				Employee hr = new HR(id, name, post, salary, commision);
				list.add(hr);
				System.out.println("Employee HR is created Successfully.");
				
				break;
			}
			
			case "Admin":
			{
				System.out.println("Commision : ");
				double allowance = scan.nextDouble();
				
				Employee a = new Admin(id, name, post, salary, allowance);
				list.add(a);
				System.out.println("Employee HR is created Successfully.");
				
				break;
			}
			
			case "Salesmanager":
			{
				System.out.println("Commision : ");
				double incentive = scan.nextDouble();
				System.out.println("Target : ");
				int target = scan.nextInt();
				
				Employee sm = new Salesmanager(id, name, post, salary, target, incentive);
				list.add(sm);
				System.out.println("Employee HR is created Successfully.");
				
				break;
			}
				

			default:
				System.out.println("Invalid Input !!!");
				break;
			}
		}
		
		

	}
	
	static void Display()
	{
		System.out.println("Database ...........");
		
		for (int i = 0; i < list.size(); i++) 
		{
			System.out.println(list.get(i));
		}
	}
	
	static void show()
	{
		System.out.println("Fetch Data By :\n1. ID \n2. Name");
		int n = scan.nextInt();
		scan.nextLine();
		
		if (n == 1) 
		{
			System.out.println("ID :");
			int id = scan.nextInt();
			scan.nextLine();
			
			for (int i = 0; i < list.size(); i++) 
			{
				if (id == list.get(i).id) 
				{
					System.out.println(list.get(i));
					System.out.println("Employee Data Found Successfully. ");
				}
				else
				{
					System.out.println("Not Found !!!");
				}
				break;
			}
		}
		if (n == 2) 
		{
			System.out.println("Name :");
			String name = scan.nextLine();
			
			for (int i = 0; i < list.size(); i++) 
			{
				if (name.equals(list.get(i).name) )
				{
					System.out.println(list.get(i));
					System.out.println("Employee Data Found Successfully. ");
				}
				else
				{
					System.out.println("Not Found !!!");
				}
				break;
			}	
		}
	}
	
	static void Delete()
	{
		System.out.println("Delete Data By :\n1. ID \n2. Name");
		int n = scan.nextInt();
		scan.nextLine();
		
		if (n == 1) 
		{
			System.out.println("ID :");
			int id = scan.nextInt();
			scan.nextLine();
			
			for (int i = 0; i < list.size(); i++) 
			{
				if (id == list.get(i).id) 
				{
					System.out.println(list.remove(i));
					System.out.println("Employee Data Deleted Successfully. ");
				}
				else
				{
					System.out.println("Not Found !!!");
				}
				break;
			}
		}
		if (n == 2) 
		{
			System.out.println("Name :");
			String name = scan.nextLine();
			
			for (int i = 0; i < list.size(); i++) 
			{
				if (name.equals(list.get(i).name) )
				{
					System.out.println(list.remove(i));
					System.out.println("Employee Data Deleted Successfully. ");
				}
				else
				{
					System.out.println("Not Found !!!");
				}
				break;
			}	
		}
	}
	
	static void Update()
	{//System.out.println("What do you want to Update \n1. Name \n2.ID \n3. Salary \n4. Post");
		System.out.println("\nTrace Data By :\n1. ID \n2. Name");
		int n = scan.nextInt();
		scan.nextLine();
		
		if (n == 1) 
		{
			System.out.println("ID :");
			int id = scan.nextInt();
			scan.nextLine();
			
			for (int i = 0; i < list.size(); i++) 
			{
				if (id == list.get(i).id) 
				{
					System.out.println(list.get(i));
					System.out.println("\nDatabase Found !!! ");
//					System.out.println(list.remove(i));
				}
				else
				{
					System.out.println("Not Found !!!");
				}
				break;
			}
			

			for (int i = 0; i < list.size(); i++) 
			{	
				Employee emp = list.get(i);
				if (emp instanceof HR) 
				{	
					HR hr = (HR)emp; 
					System.out.println("\nEmployee is HR");
					System.out.println("\nUpdate \n1. Name \n2. Salary \n3. Commision");
					int num = scan.nextInt();
					scan.nextLine();
					
					switch (num) 
					{
						case 1:
							System.out.println("Name :");
							String name = scan.nextLine();
							hr.setName();
							list.add(hr);
							System.out.println("\nEmployee HR Name is Updated  Successfully.");
							
						break;
						
						case 2:
							System.out.println("Salary :");
							double salary = scan.nextDouble();
							scan.nextLine();
							hr.setSalary();
							list.add(hr);
							System.out.println("\nEmployee HR Salary is Updated Successfully.");
						break;
						
						case 3:
							System.out.println("Commision :");
							double commision = scan.nextDouble();
							scan.nextLine();
							hr.setCommision();
							list.add(hr);
							System.out.println("\nEmployee HR Commision is Updated Successfully.");
						break;

					default:
						System.out.println("Invalid Choice.");
						break;
					}	
					
				}
				if (emp instanceof Salesmanager) 
				{	
					Salesmanager sm = (Salesmanager)emp; 
					System.out.println("\nEmployee is HR");
					System.out.println("\n\nUpdate \n1. Name \n2. Salary \n3. Incentive \n4. Target");
					int num = scan.nextInt();
					scan.nextLine();
					
					switch (num) 
					{
						case 1:
							System.out.println("Name :");
							String name = scan.nextLine();
							sm.setName();
							list.add(sm);
							System.out.println("\nEmployee Sales Manager Name is updated Successfully.");
							
						break;
						
						case 2:
							System.out.println("Salary :");
							double salary = scan.nextDouble();
							scan.nextLine();
							sm.setSalary();
							list.add(sm);
							System.out.println("\nEmployee  Sales Manager Salary is updated Successfully.");
						break;
						
						case 3:
							System.out.println("Commision :");
							double incentive = scan.nextDouble();
							scan.nextLine();
							sm.setIncentive();
							list.add(sm);
							System.out.println("\nEmployee  Sales Manager Incentive is updated Successfully.");
						break;
						
						case 4:
							System.out.println("Commision :");
							double target = scan.nextDouble();
							scan.nextLine();
							sm.setTarget();
							list.add(sm);
							System.out.println("\nEmployee  Sales Manager Target is updated Successfully.");
						break;

					default:
						System.out.println("Invalid Choice.");
						break;
					}	
					
				}
				
				if (emp instanceof Admin) 
				{	
					Admin a = (Admin)emp; 
					System.out.println("\nEmployee is Admin");
					System.out.println("\n\nUpdate \n1. Name \n2. Salary \n3. Allowance");
					int num = scan.nextInt();
					scan.nextLine();
					
					switch (num) 
					{
						case 1:
							System.out.println("Name :");
							String name = scan.nextLine();
							a.setName();
							list.add(a);
							System.out.println("\nEmployee Admin Name is updated Successfully.");
							
						break;
						
						case 2:
							System.out.println("Salary :");
							double salary = scan.nextDouble();
							scan.nextLine();
							a.setSalary();
							list.add(a);
							System.out.println("\nEmployee Admin Salary is updated Successfully.");
						break;
						
						case 3:
							System.out.println("Commision :");
							double allowance = scan.nextDouble();
							scan.nextLine();
							a.setAllowance();
							list.add(a);
							System.out.println("\nEmployee Admin Allowance is updated Successfully.");
						break;

					default:
						System.out.println("Invalid Choice.");
						break;
					}	
					
				}
			}	
		}
		if (n == 2) 
		{
			System.out.println("Name :");
			String name1 = scan.nextLine();
			
			for (int i = 0; i < list.size(); i++) 
			{
				if (name1.equals(list.get(i).name) )
				{
					System.out.println(list.get(i));
					System.out.println("\n\n\n\nDatabase Found !!! ");
				}
				else
				{
					System.out.println("Not Found !!!");
				}
				break;
			}
			
			for (int i = 0; i < list.size(); i++) 
			{	
				Employee emp = list.get(i);
				if (emp instanceof HR) 
				{	
					HR hr = (HR)emp; 
					System.out.println("\n\n\nEmployee is HR");
					System.out.println("\n\n\nUpdate \n1. Name \n2. Salary \n3. Commision");
					int num = scan.nextInt();
					scan.nextLine();
					
					switch (num) 
					{
						case 1:
							System.out.println("Name :");
							String name = scan.nextLine();
							hr.setName();
							list.add(hr);
							System.out.println("\n\n\nEmployee HR Name is Updated  Successfully.");
							
						break;
						
						case 2:
							System.out.println("Salary :");
							double salary = scan.nextDouble();
							scan.nextLine();
							hr.setSalary();
							list.add(hr);
							System.out.println("\n\n\nEmployee HR Salary is Updated Successfully.");
						break;
						
						case 3:
							System.out.println("Commision :");
							double commision = scan.nextDouble();
							scan.nextLine();
							hr.setCommision();
							list.add(hr);
							System.out.println("\n\n\nEmployee HR Commision is Updated Successfully.");
						break;

					default:
						System.out.println("Invalid Choice.");
						break;
					}	
					
				}
				if (emp instanceof Salesmanager) 
				{	
					Salesmanager sm = (Salesmanager)emp; 
					System.out.println("\n\nEmployee is HR");
					System.out.println("\n\nUpdate \n1. Name \n2. Salary \n3. Incentive \n4. Target");
					int num = scan.nextInt();
					scan.nextLine();
					
					switch (num) 
					{
						case 1:
							System.out.println("Name :");
							String name = scan.nextLine();
							sm.setName();
							list.add(sm);
							System.out.println("\n\nEmployee Sales Manager Name is updated Successfully.");
							
						break;
						
						case 2:
							System.out.println("Salary :");
							double salary = scan.nextDouble();
							scan.nextLine();
							sm.setSalary();
							list.add(sm);
							System.out.println("\n\nEmployee  Sales Manager Salary is updated Successfully.");
						break;
						
						case 3:
							System.out.println("Commision :");
							double incentive = scan.nextDouble();
							scan.nextLine();
							sm.setIncentive();
							list.add(sm);
							System.out.println("\n\nEmployee  Sales Manager Incentive is updated Successfully.");
						break;
						
						case 4:
							System.out.println("Commision :");
							double target = scan.nextDouble();
							scan.nextLine();
							sm.setTarget();
							list.add(sm);
							System.out.println("\n\nEmployee  Sales Manager Target is updated Successfully.");
						break;

					default:
						System.out.println("Invalid Choice.");
						break;
					}	
					
				}
				
				if (emp instanceof Admin) 
				{	
					Admin a = (Admin)emp; 
					System.out.println("\nEmployee is Admin");
					System.out.println("\nUpdate \n1. Name \n2. Salary \n3. Allowance");
					int num = scan.nextInt();
					scan.nextLine();
					
					switch (num) 
					{
						case 1:
							System.out.println("Name :");
							String name = scan.nextLine();
							a.setName();
							list.add(a);
							System.out.println("\nEmployee Admin Name is updated Successfully.");
							
						break;
						
						case 2:
							System.out.println("Salary :");
							double salary = scan.nextDouble();
							scan.nextLine();
							a.setSalary();
							list.add(a);
							System.out.println("\nEmployee Admin Salary is updated Successfully.");
						break;
						
						case 3:
							System.out.println("Commision :");
							double allowance = scan.nextDouble();
							scan.nextLine();
							a.setAllowance();
							list.add(a);
							System.out.println("\nEmployee Admin Allowance is updated Successfully.");
						break;

					default:
						System.out.println("Invalid Choice.");
						break;
					}	
					
				}
				break;
			}
		}
	}
	
	static class Salary implements Comparator<Employee>
	{
	    public int compare(Employee a, Employee b)
	    {
	        return Double.compare(a.salary, b.salary);
	    }
	}

	static class Post implements Comparator<Employee>
	{
	    public int compare(Employee a, Employee b)
	    {
	    	return a.post.compareToIgnoreCase(b.post);
	    }
	}

	static class Name implements Comparator<Employee>
	{
	    public int compare(Employee a, Employee b)
	    {
	    	return a.name.compareToIgnoreCase(b.name);
	    }
	}
	
	static void Sort()
	{	
		System.out.println("Sort By : \n1. ID \n2. Salary \n3. Name \n4. Post");
		int n = scan.nextInt();
		scan.nextLine();
		if (n == 1)
	    {
	        System.out.println("Sorting by ID.......");
	        Collections.sort(list);
	    }
	    else if (n == 2)
	    {
	        System.out.println("Sorting by Salary.......");
	        Collections.sort(list, new Salary());
	    }
	    else if (n == 3)
	    {
	        System.out.println("Sorting by Name.......");
	        Collections.sort(list, new Name());
	    }
	    else if (n == 4)
	    {
	        System.out.println("Sorting by Post.......");
	        Collections.sort(list, new Post());
	    }
	    else
	    {
	        System.out.println("Invalid Choice.");
	        return;
	    }

	    System.out.println("Database Sorted Successfully!");
	    Display();
	}
		
	
	
	public static void main(String[] args) 
	{
		while (true)
	    {
	        System.out.println("\n1.Create \n2.Display \n3.Show \n4.Update \n5.Delete \n6.Sort \n7.Exit");
	        int ch = scan.nextInt();
	        scan.nextLine();
	        switch (ch)
	        {
	            case 1: 
	            	Create();  
	            	break;
	            
	            case 2: 
	            	Display(); 
	            	break;
	            	
	            case 3: 
					show();    
					break;

	            case 4: 
					Update();  
					break;

	            case 5: 
					Delete();  
					break;

	            case 6: 
					Sort();    
					break;
					
	            case 7: 
	            	return;
	            	default: System.out.println("Invalid Choice.");
	        }
	    }
	}
}

