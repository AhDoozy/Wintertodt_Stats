package com.Wintertodt_Stats;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;
import com.Wintertodt_Stats.WintertodtStatsPlugin;

public class ExamplePluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(WintertodtStatsPlugin.class);
		RuneLite.main(args);
	}
}