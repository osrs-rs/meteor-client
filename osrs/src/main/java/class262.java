import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kd")
public class class262 {
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Lkd;"
   )
   static final class262 field2414 = new class262(0);
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lkd;"
   )
   static final class262 field2417 = new class262(1);
   @ObfuscatedName("ak")
   @Export("canvasHeight")
   public static int canvasHeight;
   @ObfuscatedName("aw")
   @Export("value")
   final int value;

   class262(int var1) {
      this.value = var1;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "-521149946"
   )
   public static int method1527(int var0, int var1) {
      return (-3 - var0 << 8) + var1;
   }
}
