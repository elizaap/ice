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
package org.eclipse.ice.item.utilities.trilinos;

import org.eclipse.ice.datastructures.form.AllowedValueType;
import org.eclipse.ice.datastructures.form.Entry;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * <p>
 * This class represents a Teuchos parameter. It is a simple data structure that
 * only holds data.
 * </p>
 * 
 * @author Jay Jay Billings
 */
@XmlRootElement(name = "Parameter")
public class Parameter {
	/**
	 * <p>
	 * The name of the parameter.
	 * </p>
	 * 
	 */
	@XmlAttribute
	public String name;
	/**
	 * <p>
	 * The type of the parameter.
	 * </p>
	 * 
	 */
	@XmlAttribute
	public String type;
	/**
	 * <p>
	 * The value of the parameter.
	 * </p>
	 * 
	 */
	@XmlAttribute
	public String value;

	/**
	 * This attribute describes the parameter's AllowedValueType for conversion
	 * to an ICE Entry.
	 */
	@XmlTransient
	private AllowedValueType allowedType = AllowedValueType.Continuous;

	/**
	 * <p>
	 * This operation returns this parameter as an ICE Entry. The name and value
	 * are translated directly. The value of the parameter at the time of
	 * construction as the default value. The default id value is 1 and the
	 * description is undefined. The AllowedValueType of the Entry is mapped to
	 * Discrete for a parameter type of bool, Undefined for a parameter type of
	 * string and Continuous for a parameter type of int or double. The latter
	 * has bounds of Double.POSITIVE_INFINITY and Double.NEGATIVE_INFINITY.
	 * Arrays of all types have an AllowedValueType of Undefined.
	 * </p>
	 * 
	 * @return <p>
	 *         The Entry.
	 *         </p>
	 */
	public Entry toEntry() {

		// Determine the type - default to continuous
		allowedType = AllowedValueType.Continuous;
		// Switch to Discrete or Undefined as required, but only if the type is
		// defined
		if (type != null) {
			if (type.contains("string") || type.contains("Array(")) {
				allowedType = AllowedValueType.Undefined;
			} else if (type.contains("bool")) {
				allowedType = AllowedValueType.Discrete;
			}
		}

		// Create the Entry
		Entry entry = new Entry() {
			protected void setup() {
				// Set the details
				allowedValueType = Parameter.this.allowedType;
				defaultValue = Parameter.this.value;
				value = Parameter.this.value;
				// Figure out the allowed values
				if (allowedValueType.equals(AllowedValueType.Continuous)) {
					allowedValues.add(String.valueOf(Double.NEGATIVE_INFINITY));
					allowedValues.add(String.valueOf(Double.POSITIVE_INFINITY));
				} else if (allowedValueType.equals(AllowedValueType.Discrete)) {
					allowedValues.add("true");
					allowedValues.add("false");
				}
			}
		};
		entry.setName(name);
		entry.setDescription(name);
		entry.setTag(type);
		entry.setId(1);

		return entry;
	}

	/**
	 * <p>
	 * This operation loads the Parameter from an Entry. It performs the inverse
	 * of the toEntry() operation with the added restrictions that all Arrays
	 * (determined by the presence of "{" and
	 * "}) have a type of Array(string) and all floating point numbers (determined by the presence of "
	 * ." for an AllowedValueType of Continuous) have type double. All types of
	 * Discrete are consider to be bool.
	 * </p>
	 * 
	 * @param entry
	 *            <p>
	 *            The Entry.
	 *            </p>
	 */
	public void fromEntry(Entry entry) {

		// Only load if the Entry is not null
		if (entry != null) {
			// Get the type and value
			AllowedValueType allowedType = entry.getValueType();
			String entryValue = entry.getValue();
			// Figure out the type
			if (allowedType.equals(AllowedValueType.Continuous)) {
				type = (entryValue.contains(".")) ? "double" : "int";
			} else if (allowedType.equals(AllowedValueType.Undefined)) {
				type = (!entryValue.contains("{") && !entryValue.contains("}")) ? "string"
						: "Array(string)";
			} else {
				type = "bool";
			}
			// Set the name and value
			name = entry.getName();
			value = entryValue;
		}

		return;

	}
}