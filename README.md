# CrateCreator
This is a Java Desktop Application to create crates easily for CrazyCrates plugin.

It's initially made for personal usage so it's not well documented. You can open issue if you need help.

# Usage
- Download latest build from releases tab.
- Edit the crate.yml in CrateCreator/db folder. Don't add *Prizes* section. This will be handled by CrateCreator.
- Run the program and add RRL's. RRL means Real Rarity Level and will be used for calculating item chances. By default I set Rare1: 50, Rare2: 25 and Legendary1: 25. So thanks to RRL we can add different chances for the same rarity level.
- Add items. This is where RRL makes much more sense. You can add unlimited items to an RRL and this program will automatically set chances to each item depending on the RRL. For example if you add 10 items to Rare1 RRL we set before, every item will have 5% chance. And lets say you added 10 items to Rare2, these items will have 2.5% chance even though they both would be seen by players to have Rare chance.
- Bake config.
- Now you can use the crate.yml you edited before in CrazyCrates.

It was really useful back when I worked with CrazyCrates. I hope it can be useful for you as well. Have fun and don't hesitate to ask any questions.
