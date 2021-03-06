/*
 * Copyright 2011 Tim Berglund
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Tim Berglund
 * The August Technology Group
 * http://augusttechgroup.com/tim/about
 *
 */

package com.augusttechgroup.gradle.liquibase

import org.gradle.api.NamedDomainObjectContainer


class LiquibaseDatabaseConvention {

  final NamedDomainObjectContainer<Database> databases
  final NamedDomainObjectContainer<ChangeLog> changelogs
  Database workingDatabase
  String context

  LiquibaseDatabaseConvention(NamedDomainObjectContainer<Database> databases,
                              NamedDomainObjectContainer<Database> changelogs) {
    this.databases = databases
    this.changelogs = changelogs
  }

  def databases(Closure closure) {
    databases.configure(closure)
  }

  def changelogs(Closure closure) {
    changelogs.configure(closure)
  }
}
