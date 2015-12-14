package fr.iutvalence.info.dut.m3105.pattern.state;

import java.util.List;


public class TrafficSignal extends Thread implements TrafficSignalContext, TrafficSignalUserInterface
{
	private TrafficSignalState state;
	private List<TSObserver> observer;
	
	public public TrafficSignal() {
		this.observer = new List<TSObserver>();
	}

	@Override
	public void setTrafficSignalState(TrafficSignalState state)
	{
		System.out.println("Traffic signal state is "+state.getName());
		this.state = state;		
		
		for(TSObserver tso : this.observer){
			tso.notifyColorChanged(state.getName());
		}
	}

	@Override
	public void pressButton()
	{
		this.state.buttonPressed();
		for(TSObserver tso : this.observer){
			tso.notifyButtonPressed();
		}
	}
	
	public void run()
	{
		this.setTrafficSignalState(new TrafficSignalGreenState(this));
		while (true)
		{
			try
			{
				Thread.sleep(1000);
				this.state.secondEllapsed();
			}
			catch (InterruptedException e)
			{
				break;
			}
		}
	}
	
	public void registerTSObserver(TSObserver tsco){
		this.observer.add(tsco);
	}
	
	public void unregisterTSObserver(TSObserver tsco){
		this.observer.remove(tsco);
	}
	
}
