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
package org.eclipse.ice.datastructures.form.geometry;

/**
 * <p>
 * Implementing&nbsp;this&nbsp;interface&nbsp;allows&nbsp;a&nbsp;class&nbsp;to&
 * nbsp
 * ;discover&nbsp;the&nbsp;type&nbsp;of&nbsp;an&nbsp;IShape&nbsp;through&nbsp
 * ;the&nbsp;visitor&nbsp;design&nbsp;pattern
 * </p>
 * 
 * @author Jay Jay Billings
 */
public interface IShapeVisitor {
	/**
	 * <p>
	 * Visits&nbsp;an&nbsp;IShapeVisitor&nbsp;as&nbsp;a&nbsp;ComplexShape
	 * </p>
	 * 
	 * @param complexShape
	 */
	public void visit(ComplexShape complexShape);

	/**
	 * <p>
	 * Visits&nbsp;an&nbsp;IShapeVisitor&nbsp;as&nbsp;a&nbsp;PrimitiveShape
	 * </p>
	 * 
	 * @param primitiveShape
	 */
	public void visit(PrimitiveShape primitiveShape);
}