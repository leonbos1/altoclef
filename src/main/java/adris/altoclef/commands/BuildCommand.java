package adris.altoclef.commands;

import adris.altoclef.AltoClef;
import adris.altoclef.buildings.*;
import adris.altoclef.commandsystem.*;
import adris.altoclef.tasks.construction.build2DBuildingTask;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import java.util.Objects;

public class BuildCommand extends Command {

    public BuildCommand() throws CommandException {
        super("build", "build a 2d structure",
                new Arg(String.class, "structure"),
                new Arg(String.class, "blocktype")
        );

    }

    private Building getBuilding(String building, Block blocktype) {
        return switch (building) {
            case "a" -> new A(blocktype);
            case "b" -> new B(blocktype);
            case "c" -> new C(blocktype);
            case "d" -> new D(blocktype);
            case "e" -> new E(blocktype);
            case "f" -> new F(blocktype);
            case "g" -> new G(blocktype);
            case "h" -> new H(blocktype);
            case "i" -> new I(blocktype);
            case "j" -> new J(blocktype);
            case "k" -> new K(blocktype);
            case "l" -> new L(blocktype);
            case "m" -> new M(blocktype);
            case "n" -> new N(blocktype);
            case "o" -> new O(blocktype);
            case "p" -> new P(blocktype);
            case "q" -> new Q(blocktype);
            case "r" -> new R(blocktype);
            case "s" -> new S(blocktype);
            case "t" -> new T(blocktype);
            case "u" -> new U(blocktype);
            case "v" -> new V(blocktype);
            case "w" -> new W(blocktype);
            case "x" -> new X(blocktype);
            case "y" -> new Y(blocktype);
            case "z" -> new Z(blocktype);
            case "hakenkruis" -> new Hakenkruis(blocktype);
            default -> new A(blocktype);
        };
    }

    @Override
    protected void call(AltoClef mod, ArgParser parser) throws CommandException {

        String structure = parser.get(String.class);
        String blockString = parser.get(String.class);
        Block block = StringToBlock.stringToBlock(blockString);

        Building building = getBuilding(structure, block);

        mod.runUserTask(new build2DBuildingTask(mod, building), this::finish);

    }
}
