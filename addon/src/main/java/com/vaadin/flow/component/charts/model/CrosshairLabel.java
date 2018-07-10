package com.vaadin.flow.component.charts.model;

/*-
 * #%L
 * Vaadin Charts for Flow
 * %%
 * Copyright (C) 2014 - 2018 Vaadin Ltd
 * %%
 * This program is available under Commercial Vaadin Add-On License 3.0
 * (CVALv3).
 * 
 * See the file licensing.txt distributed with this software for more
 * information about licensing.
 * 
 * You should have received a copy of the CVALv3 along with this program.
 * If not, see <https://vaadin.com/license/cval-3>.
 * #L%
 */

import javax.annotation.Generated;

/**
 * A label on the axis next to the crosshair. In styled mode, the label is
 * styled with the `.highcharts-crosshair-label` class.
 */
@Generated(value = "This class is generated and shouldn't be modified", comments = "Incorrect and missing API should be reported to https://github.com/vaadin/vaadin-charts-flow/issues/new")
public class CrosshairLabel extends AbstractConfigurationObject {

	private HorizontalAlign align;
	private Number borderRadius;
	private String format;
	private String _fn_formatter;
	private Number padding;
	private Shape shape;

	public CrosshairLabel() {
	}

	/**
	 * @see #setAlign(HorizontalAlign)
	 */
	public HorizontalAlign getAlign() {
		return align;
	}

	/**
	 * Alignment of the label compared to the axis. Defaults to `left` for
	 * right-side axes, `right` for left-side axes and `center` for horizontal
	 * axes.
	 */
	public void setAlign(HorizontalAlign align) {
		this.align = align;
	}

	/**
	 * @see #setBorderRadius(Number)
	 */
	public Number getBorderRadius() {
		return borderRadius;
	}

	/**
	 * The border corner radius of the crosshair label.
	 */
	public void setBorderRadius(Number borderRadius) {
		this.borderRadius = borderRadius;
	}

	/**
	 * @see #setFormat(String)
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * A format string for the crosshair label. Defaults to `{value}` for
	 * numeric axes and `{value:%b %d, %Y}` for datetime axes.
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * @see #set_fn_formatter(String)
	 */
	public String getFormatter() {
		return _fn_formatter;
	}

	/**
	 * Formatter function for the label text.
	 */
	public void setFormatter(String _fn_formatter) {
		this._fn_formatter = _fn_formatter;
	}

	/**
	 * @see #setPadding(Number)
	 */
	public Number getPadding() {
		return padding;
	}

	/**
	 * Padding inside the crosshair label.
	 */
	public void setPadding(Number padding) {
		this.padding = padding;
	}

	/**
	 * @see #setShape(Shape)
	 */
	public Shape getShape() {
		return shape;
	}

	/**
	 * The shape to use for the label box.
	 */
	public void setShape(Shape shape) {
		this.shape = shape;
	}
}
