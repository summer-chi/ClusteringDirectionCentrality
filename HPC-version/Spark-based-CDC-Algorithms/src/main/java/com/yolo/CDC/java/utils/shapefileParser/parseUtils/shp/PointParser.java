/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.yolo.CDC.java.utils.shapefileParser.parseUtils.shp;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import java.io.IOException;

public class PointParser
        extends ShapeParser
{

    /**
     * create a parser that can abstract a Point from input source with given GeometryFactory.
     *
     * @param geometryFactory the geometry factory
     */
    public PointParser(GeometryFactory geometryFactory)
    {
        super(geometryFactory);
    }

    /**
     * abstract a Point shape.
     *
     * @param reader the reader
     * @return the geometry
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public Geometry parseShape(ShapeReader reader)
    {
        double x = reader.readDouble();
        double y = reader.readDouble();
        Point point = geometryFactory.createPoint(new Coordinate(x, y));
        return point;
    }
}
