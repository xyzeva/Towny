package com.palmergames.bukkit.towny.object.economy;

import com.palmergames.bukkit.towny.object.EconomyHandler;

/**
 * Defines methods necessary for the operation of a bank.
 */
public interface TownyServerAccountEconomyHandler extends EconomyHandler {
	/**
	 * Gets the account associated with the TownyServerAccount
	 *
	 * @return The TownyServerAccount
	 */
	@Override
	Account getAccount(); // Covariant return type of Account from superinterface
}
