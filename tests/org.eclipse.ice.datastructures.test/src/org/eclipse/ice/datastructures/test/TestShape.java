/*******************************************************************************
 * Copyright (c) 2012, 2014 UT-Battelle, LLC.
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
package org.eclipse.ice.datastructures.test;

import org.eclipse.ice.datastructures.form.geometry.AbstractShape;
import org.eclipse.ice.datastructures.form.geometry.IShapeVisitor;

/**
 * <p>
 * Used to test the functionality of AbstractShape
 * </p>
 * 
 * @author Jay Jay Billings
 */
public class TestShape extends AbstractShape {
	/**
	 * <p>
	 * This operation returns a clone of the ICEObject using a deep copy.
	 * </p>
	 * 
	 * @return <p>
	 *         The new cloned object
	 *         </p>
	 */
	public Object clone() {

		// Create a new instance of TestShape
		TestShape testShape = new TestShape();

		// Copy the contents of this into the new TestShape
		testShape.copy(this);

		// Return the cloned TestShape
		return testShape;

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IUpdateable#update(String updatedKey, String newValue)
	 */
	public void update(String updatedKey, String newValue) {
		// Not implemented
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IShape#acceptShapeVisitor(IShapeVisitor visitor)
	 */
	public void acceptShapeVisitor(IShapeVisitor visitor) {
		// TODO Auto-generated method stub

	}
}