## About
A minimalistic Xposed framework which is based on [LSPlant](https://github.com/LSPosed/LSPlant).

## Support
Currently, it supports all Android version from 5.0 to 13.0. All main architectures of Android are supported (arm64-v8a, armeabi-v7a, x86, x86_64)

**If you're having issue with compatibility, consider downgrading the targetSdkVersion to 28 or below.**

## Usage
If you are not familiar with the Xposed API, here's a quick example of how to hook **onCreate** of **Activity.java** class. You can find the example in [MainApplication](app/src/main/java/com/arc/xposed/MainApplication.java).
```java
        XposedHelpers.findAndHookMethod(Activity.class, "onCreate", Bundle.class, new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                Toast.makeText(MainApplication.this, "Hooked!", Toast.LENGTH_LONG).show();
                return XposedBridge.invokeOriginalMethod(param.method, param.thisObject, param.args);
            }
        });
```
**Currently, there is no support for Resource Hooks**

## Donation
If you appreciate this project, feel free to donate :)

Bitcoin Address: bc1qmu2fqddueu0yw754xfjk2ugh7qrp00msgm4u2w

Litcoin Address: ltc1ql4xv66lkkutj9t5pdq3wqhuvzjw8tgndc0zynp

Ethereum Address: 0xeb12e38Bd62C1e919649fF4D085de71b952c7310

## Credits
[Dobby](https://github.com/jmpews/Dobby)

[LSPosed](https://github.com/LSPosed/LSPosed)

[XposedBridge](https://github.com/rovo89/XposedBridge)
