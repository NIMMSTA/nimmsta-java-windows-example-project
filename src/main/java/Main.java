import com.nimmsta.barcode.Barcode;
import com.nimmsta.core.jvm.framework.ConnectionManager;
import com.nimmsta.core.shared.device.NIMMSTADevice;
import com.nimmsta.core.shared.device.NIMMSTAEventHandler;
import com.nimmsta.core.shared.exception.bluetooth.BluetoothDisconnectedException;
import com.nimmsta.core.shared.layout.element.Button;
import com.nimmsta.core.shared.layout.event.ButtonClickEvent;
import com.nimmsta.core.shared.textprotocol.event.Event;
import com.nimmsta.core.shared.textprotocol.event.RequestShutdown;
import com.nimmsta.core.shared.textprotocol.event.ScanEvent;
import com.nimmsta.core.shared.textprotocol.event.TouchEvent;
import com.nimmsta.core.shared.textprotocolapi.softwareupdate.model.SoftwareUpdateProgress;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ExampleEventHandler implements NIMMSTAEventHandler {

    @Override
    public void didStartConnecting(@NotNull NIMMSTADevice nimmstaDevice) {
        // Connection process has started
        // Device interaction not yet possible
    }

    @Override
    public void didConnectAndInit(@NotNull NIMMSTADevice nimmstaDevice) {
        // Device interaction is now possible
    }

    @Override
    public boolean deviceShouldHandover(@NotNull NIMMSTADevice nimmstaDevice) {
        return false;
    }

    @Override
    public boolean deviceWillShutdown(@NotNull NIMMSTADevice nimmstaDevice, boolean b) {
        return false;
    }

    @Override
    public void didScanBarcode(@NotNull NIMMSTADevice nimmstaDevice, @NotNull Barcode barcode, @NotNull ScanEvent scanEvent) {

    }

    @Override
    public void didTouch(@NotNull NIMMSTADevice nimmstaDevice, double v, double v1, int i, @NotNull TouchEvent touchEvent) {

    }

    @Override
    public boolean allowShutdownByUser(@NotNull NIMMSTADevice nimmstaDevice, @NotNull RequestShutdown requestShutdown) {
        return false;
    }

    @Override
    public void batteryLevelChanged(@NotNull NIMMSTADevice nimmstaDevice, int i) {

    }

    @Override
    public void didClickButton(@NotNull NIMMSTADevice nimmstaDevice, @Nullable Button button, @NotNull ButtonClickEvent buttonClickEvent) {

    }

    @Override
    public void didDisconnect(@NotNull NIMMSTADevice nimmstaDevice, @NotNull BluetoothDisconnectedException.Reason reason) {

    }

    @Override
    public void didReceiveEvent(@NotNull NIMMSTADevice nimmstaDevice, @NotNull Event event) {

    }

    @Override
    public void didStartCharging(@NotNull NIMMSTADevice nimmstaDevice) {

    }

    @Override
    public void didStartReconnectSearch(@NotNull NIMMSTADevice nimmstaDevice) {

    }

    @Override
    public void didStopCharging(@NotNull NIMMSTADevice nimmstaDevice) {

    }

    @Override
    public void didStopReconnectSearch(@NotNull NIMMSTADevice nimmstaDevice) {

    }

    @Override
    public boolean onError(@Nullable NIMMSTADevice nimmstaDevice, @NotNull Throwable throwable) {
        return false;
    }

    @Override
    public void softwareUpdateProgress(@NotNull NIMMSTADevice nimmstaDevice, @NotNull SoftwareUpdateProgress softwareUpdateProgress) {

    }

    @Override
    public void softwareUpgradeProgress(@NotNull NIMMSTADevice nimmstaDevice, @NotNull SoftwareUpdateProgress softwareUpdateProgress) {

    }

}

class Main {
    public static void main(String[] args) throws InterruptedException {
        ConnectionManager connectionManager = new ConnectionManager();
        ExampleEventHandler eventHandler = new ExampleEventHandler();
        connectionManager.startReceivingEvents(eventHandler);
        connectionManager.displayConnectionActivity(false);

        // Prevent app from exiting
        while (true) {
            Thread.sleep(10);
        }
    }
}