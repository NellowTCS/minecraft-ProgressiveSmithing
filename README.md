# Progressive Smithing

Progressive Smithing adds tiered smithing templates that let armor, tools, and weapons move through a simple upgrade ladder: leather to copper, copper to gold, gold to chainmail, chainmail to iron, and iron to diamond.

The mod is built for Minecraft 1.21.10 with Architectury, so the same codebase can target Fabric and NeoForge.

## What it does

- Adds custom smithing templates for each upgrade step.
- Places the templates in loot so they can be found in normal play.
- Adds smithing recipes for armor and tools.
- Uses a vanilla-style Ingredients tab entry on Fabric.

## Requirements

- Minecraft 1.21.10
- Java 21
- Fabric Loader 0.19.2 on Fabric
- NeoForge Loader

## Building

Use the Gradle wrapper from the project root:

```bash
export JAVA_HOME="$(brew --prefix openjdk@21)/libexec/openjdk.jdk/Contents/Home"
./gradlew build
```

The built jars are written to the platform `build/libs` folders.

## Running in development

To launch the Fabric client:

```bash
export JAVA_HOME="$(brew --prefix openjdk@21)/libexec/openjdk.jdk/Contents/Home"
./gradlew :fabric:runClient
```

## License

This project is licensed under the MIT License.
