/*
 * This file is part of FlightControl, which is licensed under the MIT License.
 * Copyright (c) 2024 George Fang
 */

package org.spazzinq.flightcontrol.check.territory.trusted;

import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.ClaimPermission;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.entity.Player;
import org.spazzinq.flightcontrol.check.territory.TerritoryCheck;

public final class GriefPreventionTrustedCheck extends TerritoryCheck {
    @Override public boolean check(Player p) {
        Claim claim = GriefPrevention.instance.dataStore.getClaimAt(p.getLocation(), true, null);
        
        return claim != null && claim.hasExplicitPermission(p.getUniqueId(), ClaimPermission.Build);
    }
}
