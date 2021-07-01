package week5;

public class thread6 
{
	public static void main(String[] args)throws Exception 
	{
		canon mm=new canon();
		shooterthegun bb=new shooterthegun(mm);
		Thread n1=new Thread(bb,"azeez");
		Thread n2=new Thread(bb,"ansari");
		
		n1.start();
		n2.start();
	}
}
class shooterthegun implements Runnable
{
	canon s;
	public shooterthegun(canon s) 
	{
		this.s=s;
	}
	public void run() 
	{	
		Thread m=Thread.currentThread();
		if(m.getName().equals("azeez"))
		{
			for(int i=0;i<5;i++)
			{
				s.fill();
			}
		}
		else if(m.getName().equals("ansari"))
		{
			for(int i=0;i<5;i++)
			{
				s.shoot();
			}
		}
	}
}
class canon
{
	boolean flag;
	synchronized public void fill()
	{
		Thread t=Thread.currentThread();
		String name=t.getName();
		if(flag)
		{
			try {wait();}catch(Exception bb) {}
		}
		System.out.println(name +" fill the gun:.......");
		flag=true;
		notify();
	}
	synchronized public void shoot()
	{
		Thread t=Thread.currentThread();
		String name=t.getName();
		if(!flag)
		{
			try {wait();}catch(Exception bb) {}
		}
		System.out.println(name +" shoot the gun:..........");
		flag=false;
		notify();
	}
}