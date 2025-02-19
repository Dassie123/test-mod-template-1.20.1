package net.petrus.testmod.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.petrus.testmod.TestMod;

public class ModSounds {
    public static final SoundEvent TREASURE_FINDER_FOUND_TREASURE = registerSoundEvent("treasure_finder_found_treasure");

    public static final SoundEvent MAGIC_BLANKET_LAMP_BREAK = registerSoundEvent("magic_blanket_lamp_break");
    public static final SoundEvent MAGIC_BLANKET_LAMP_STEP = registerSoundEvent("magic_blanket_lamp_step");
    public static final SoundEvent MAGIC_BLANKET_LAMP_PLACE = registerSoundEvent("magic_blanket_lamp_place");
    public static final SoundEvent MAGIC_BLANKET_LAMP_HIT = registerSoundEvent("magic_blanket_lamp_hit");
    public static final SoundEvent MAGIC_BLANKET_LAMP_FALL = registerSoundEvent("magic_blanket_lamp_fall");

    public static final SoundEvent BAR_BRAWL = registerSoundEvent("bar_brawl");


    public static final BlockSoundGroup MAGIC_BLANKET_LAMP_SOUNDS = new BlockSoundGroup(1f, 1f,
            MAGIC_BLANKET_LAMP_BREAK, MAGIC_BLANKET_LAMP_STEP, MAGIC_BLANKET_LAMP_PLACE, MAGIC_BLANKET_LAMP_HIT, MAGIC_BLANKET_LAMP_FALL);

    public static SoundEvent registerSoundEvent (String name) {
        Identifier identifier = new Identifier(TestMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerSounds () {
        TestMod.LOGGER.info("Registering Mod Sounds for " + TestMod.MOD_ID);
    }
}
