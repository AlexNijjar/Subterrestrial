<div align="center">

## Subterrestrial

[![Modrinth](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/modrinth_vector.svg)](https://modrinth.com/mod/subterrestrial)
[![CurseForge](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/curseforge_vector.svg)](https://www.curseforge.com/minecraft/mc-mods/subterrestrial)
<hr>

### 📖About 📖

<hr>
</div>

Subterrestrial adds new structures, Underground Cabins. These are stacked two-to-three-story subsurface houses that are
based on Terraria's [Underground Cabins](https://terraria.fandom.com/wiki/Underground_Cabin) They contain
one main chest and multiple smaller chests, furniture and
workstations throughout the structure.

- Biome variations: Eight different cabin types, depending on the biome: Default, Deepslate, Desert, Mesa, Taiga, Ice,
  Jungle and Ocean.
- Cabin variations: Cabins feature random loot, rooms, degradation, foliage and destruction. No two cabins are the same!

## Developers

To add this library to your project, do the following:

```groovy
repositories {
  maven {
    // Location of the maven that hosts Alex's and Team Resourceful's files.
    name = "Team Resourceful Maven"
    url = "https://maven.resourcefulbees.com/repository/maven-public/"
  }
}
```

In an Architectury project, you would implement it like so:

Common

```groovy
dependencies {
    modImplementation "dev.alexnijjar.subterrestrial:subterrestrial-common-$rootProject.minecraft_version:$rootProject.subterrestrial_version"
}
```

Fabric

```groovy
dependencies {
    modImplementation "dev.alexnijjar.subterrestrial:subterrestrial-fabric-$rootProject.minecraft_version:$rootProject.subterrestrial_version"
}
```

Forge

```groovy
dependencies {
    modImplementation "dev.alexnijjar.subterrestrial:subterrestrial-forge-$rootProject.minecraft_version:$rootProject.subterrestrial_version"
}
```

---

<div align="center">

![Version](https://img.shields.io/maven-metadata/v?label=Subterrestrial%20Version&metadataUrl=https%3A%2F%2Fmaven.resourcefulbees.com%2Frepository%2Falexnijjar%2Fdev%2Falexnijjar%2Fsubterrestrial-common-1.19.4%2Fmaven-metadata.xml)
</div>
