package fr.iutvalence.info.dut.m3105.pattern.state;


public abstract class TrafficSignalState 
{
	protected final TrafficSignalContext context;
	protected int durationInSeconds;
	private final TSColor name;
	
	public TrafficSignalState(TrafficSignalContext context, int durationInSeconds, TSColor name)
	{
		super();
		this.context = context;
		this.durationInSeconds = durationInSeconds;
		this.name = name;
	}

	public void buttonPressed() 
	{
		System.out.println("button pressed!");
	}

	public void secondEllapsed() 
	{
		this.durationInSeconds--;
		System.out.println(this.durationInSeconds);
	}

	public TSColor getName()
	{
		return this.name;
	}
}
