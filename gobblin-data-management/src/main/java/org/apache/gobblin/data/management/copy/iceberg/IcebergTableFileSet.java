/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.gobblin.data.management.copy.iceberg;

import java.io.IOException;
import java.util.Collection;
import org.apache.gobblin.data.management.copy.CopyConfiguration;
import org.apache.gobblin.data.management.copy.CopyEntity;

/**
 * A {@link IcebergFileSet} that generates {@link CopyEntity}s for a Hive Catalog based Iceberg table
 */
public class IcebergTableFileSet extends IcebergFileSet{

  private final CopyConfiguration copyConfiguration;
  public IcebergTableFileSet(String name, IcebergDataset icebergDataset, CopyConfiguration configuration) {
    super(name, icebergDataset);
    this.copyConfiguration = configuration;
  }

  @Override
  protected Collection<CopyEntity> generateCopyEntities() throws IOException {
    return this.getIcebergDataset().generateCopyEntitiesForTableFileSet(this.copyConfiguration);
  }
}
