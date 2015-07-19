 import net.minecraft.client.network.NetworkPlayerInfo;
 import net.minecraft.client.renderer.ThreadDownloadImageData;
 import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
 
 import java.lang.reflect.Field;
 import java.net.URL;
 
 /**
  * Default Cape implementation
- * 
+ *
  * @author jadar
  */
 public class StaticCape extends AbstractCape {
 @@ -41,16 +43,17 @@ public void loadTexture(AbstractClientPlayer player) {
 
         //mmdanggg2: using reflection to modify the private locationCape, hacky but it works.
         try {
            Field playerInfoF = AbstractClientPlayer.class.getDeclaredField("playerInfo");
        	Field playerInfoF = ReflectionHelper.findField(AbstractClientPlayer.class, "playerInfo", "field_175157_a");
             playerInfoF.setAccessible(true);
             NetworkPlayerInfo nci = (NetworkPlayerInfo) playerInfoF.get(player);
 
           Field locationCapeF = NetworkPlayerInfo.class.getDeclaredField("locationCape");
           Field locationCapeF = ReflectionHelper.findField(NetworkPlayerInfo.class, "locationCape", "field_178862_f");
             locationCapeF.setAccessible(true);
             locationCapeF.set(nci, location);
 
             playerInfoF.setAccessible(false);
             locationCapeF.setAccessible(false);

         } catch (Exception e) {
             e.printStackTrace();
             DevCapes.getInstance().logger.error("Setting cape ResourceLocation failed!");
