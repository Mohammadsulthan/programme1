package tvproblem;

public class Atv 
{
	public static void main(String[] args) 
	{
		Tv tv=new Tv();
		SetTopBox setTopBox=new SetTopBox();
		NetFlix netflix=new NetFlix();
		SoundSystem soundsystem=new SoundSystem();
		
		FatherNewsChannelCommand fncc=new FatherNewsChannelCommand(tv, setTopBox, netflix, soundsystem);
		MotherOldMovieCommand msc=new MotherOldMovieCommand(tv, setTopBox, netflix, soundsystem);
		MotherSerialCommand mm=new MotherSerialCommand(tv, setTopBox, netflix, soundsystem);
		
		remote universalRemote=new remote();
	
		universalRemote.setcommand(fncc, 1);
		universalRemote.setcommand(msc, 2);
		universalRemote.setcommand(mm, 3);
		
	
		universalRemote.excutecommand(3);
		
	}
}

class Tv
{
	public void av1()
	{
		System.out.println("tv switch on av1 mode:...");
	}
	public void switchon()
	{
		System.out.println("tv switch on:.....");
	}
}
class SetTopBox
{
	public void newschannel()
	{
		System.out.println("news channel started:...... ");
	}
	public void serialchannel()
	{
		System.out.println("serial channel started:.....");
	}
}
class NetFlix
{
	public void movieold()
	{
		System.out.println("old movie started:.....");
	}
}
class SoundSystem
{
	public void lowsound()
	{
		System.out.println("sound volume.....decreased..");
	}
}
interface command
{
	public void excute();
}
class FatherNewsChannelCommand implements command
{
	Tv tv;SetTopBox setTopBox;NetFlix netflix;SoundSystem soundsystem;
	public FatherNewsChannelCommand(Tv tv,SetTopBox setTopBox,NetFlix netflix,SoundSystem soundsystem)
	{
		this.tv=tv;
		this.setTopBox=setTopBox;
		this.netflix=netflix;
		this.soundsystem=soundsystem;
	}
	public void excute()
	{
		System.out.println("father tv action started.....");
		tv.switchon();
		tv.av1();
		setTopBox.newschannel();
		soundsystem.lowsound();
		System.out.println("dad enjoy your news channel:.....");
	}
}
class MotherOldMovieCommand implements command
{
	Tv tv;SetTopBox setTopBox;NetFlix netflix;SoundSystem soundsystem;
	public MotherOldMovieCommand(Tv tv,SetTopBox setTopBox,NetFlix netflix,SoundSystem soundsystem)
	{
		this.tv=tv;
		this.setTopBox=setTopBox;
		this.netflix=netflix;
		this.soundsystem=soundsystem;
	}
	public void excute()
	{
		System.out.println("mother old movie");
		tv.switchon();
		tv.av1();
		netflix.movieold();
		System.out.println("enjoy the old movie mom.........");
	}
}
class MotherSerialCommand implements command
{
	Tv tv;SetTopBox setTopBox;NetFlix netflix;SoundSystem soundsystem;
	public MotherSerialCommand(Tv tv,SetTopBox setTopBox,NetFlix netflix,SoundSystem soundsystem)
	{
		this.tv=tv;
		this.setTopBox=setTopBox;
		this.netflix=netflix;
		this.soundsystem=soundsystem;
	}
	public void excute()
	{
		System.out.println("mother serial command started....");
		tv.switchon();
		tv.av1();
		setTopBox.serialchannel();
		System.out.println("enjoy the serial mom.........");
	}
}
class DummyCommand implements command
{
	public void excute()
	{
		System.out.println("i am a dummay button...");
	}
}
class remote
{
	command comm[]=new command[5];
	public remote()
	{
		for(int i=0;i<comm.length;i++)
		{
			comm[i]=new DummyCommand();
		}
	}
	public void setcommand(command comm,int slot)
	{
		this.comm[slot]=comm;
	}
	public void excutecommand(int slot)
	{
		comm[slot].excute();
	}
}
