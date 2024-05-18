package com.palmergames.bukkit.towny.object.economy;

import java.util.UUID;

import com.palmergames.bukkit.config.ConfigNodes;
import com.palmergames.bukkit.towny.TownyEconomyHandler;
import com.palmergames.bukkit.towny.TownySettings;

/**
 * For internal use only.
 */
public class TownyServerAccount extends Account {
	private final static UUID uuid = UUID.fromString("a73f39b0-1b7c-2930-b4a3-ce101812d926");
	private final static String name = TownySettings.getString(ConfigNodes.ECO_CLOSED_ECONOMY_SERVER_ACCOUNT);

	public TownyServerAccount() {
		super(name, uuid);
	}

	@Override
	protected synchronized boolean addMoney(double amount) {
		return TownyEconomyHandler.add(this, amount);
	}

	@Override
	protected synchronized boolean subtractMoney(double amount) {
		return TownyEconomyHandler.subtract(this, amount);
	}
}
