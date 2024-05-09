package dji.sampleV5.aircraft.models

import dji.sdk.keyvalue.key.FlightAssistantKey
import dji.sdk.keyvalue.key.FlightControllerKey
import dji.sdk.keyvalue.value.common.EmptyMsg
import dji.v5.common.callback.CommonCallbacks
import dji.v5.common.error.IDJIError
import dji.v5.et.action
import dji.v5.et.create
import dji.v5.et.get

//class BasicAircraftControlVM : DJIViewModel() {
//
//    fun startTakeOff(callback: CommonCallbacks.CompletionCallbackWithParam<EmptyMsg>) {
//        FlightControllerKey.KeyStartTakeoff.create().action({
//            callback.onSuccess(it)
//        }, { e: IDJIError ->
//            callback.onFailure(e)
//        })
//    }
//
//    fun startLanding(callback: CommonCallbacks.CompletionCallbackWithParam<EmptyMsg>) {
//        FlightControllerKey.KeyStartAutoLanding.create().action({
//            callback.onSuccess(it)
//        }, { e: IDJIError ->
//            callback.onFailure(e)
//        })
//    }
//}
class BasicAircraftControlVM : DJIViewModel() {

    fun startTakeOff(callback: CommonCallbacks.CompletionCallbackWithParam<EmptyMsg>) {
        FlightControllerKey.KeyStartTakeoff.create().action({
            callback.onSuccess(it)
        }, { e: IDJIError ->
            callback.onFailure(e)
        })
    }

    fun startLanding(callback: CommonCallbacks.CompletionCallbackWithParam<EmptyMsg>) {
        FlightControllerKey.KeyStartAutoLanding.create().action({
            callback.onSuccess(it)
        }, { e: IDJIError ->
            callback.onFailure(e)
        })
        if(FlightControllerKey.KeyIsLandingConfirmationNeeded.create().get() == true){
            FlightControllerKey.KeyConfirmLanding.create().action()
        }
//  添加降落控制可使无人机在高度低于0.5m时仍能降落，否则在距地0.5m时会出避障保护
    }
}