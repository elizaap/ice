/*******************************************************************************
 * Copyright (c) 2013, 2014 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Jay Jay Billings,
 *   Jordan H. Deyton, Dasha Gorin, Alexander J. McCaskey, Taylor Patterson,
 *   Claire Saunders, Matthew Wang, Anna Wojtowicz
 *******************************************************************************/
package org.eclipse.ice.vibe.kvPair;

import org.eclipse.core.resources.IProject;
import org.eclipse.ice.item.Item;
import org.eclipse.ice.item.ItemBuilder;
import org.eclipse.ice.item.ItemType;

/**
 * The ItemBuilder for the VibeKVPair Item.
 * @author Jay Jay Billings
 *
 */
public class VibeKVPairBuilder implements ItemBuilder {

	// The Item name
	public static final String name = "VIBE Key-Value Pair";
	
	// The type
	public static final ItemType type = ItemType.Model;

	/* (non-Javadoc)
	 * @see org.eclipse.ice.item.ItemBuilder#getItemName()
	 */
	@Override
	public String getItemName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ice.item.ItemBuilder#getItemType()
	 */
	@Override
	public ItemType getItemType() {
		return type;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ice.item.ItemBuilder#build(org.eclipse.core.resources.IProject)
	 */
	@Override
	public Item build(IProject projectSpace) {
		return new VibeKVPair(projectSpace);
	}

}