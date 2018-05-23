//
//  HMCustomModule.m
//  axxtHomeApp
//
//  Created by 唐嗣成 on 2018/5/22.
//  Copyright © 2018年 benmu. All rights reserved.
//

#import "HMCustomModule.h"
#import "HMUnlockView.h"
#define ROOT_CONTROLLER [[UIApplication sharedApplication] delegate].window.rootViewController

@implementation HMCustomModule
@synthesize weexInstance;
WX_EXPORT_METHOD(@selector(addGesturePage:))
WX_EXPORT_METHOD(@selector(checkGesturePage:))

-(void)addGesturePage:(WXModuleCallback)callback{
//    [ROOT_CONTROLLER.view endEditing:YES];
    [HMUnlockView showUnlockViewWithType:YWUnlockViewCreate callBack:^(BOOL result) {
        if(callback){
            if(result){
                callback(@"success");
            }else{
                callback(@"fail");
            }
        }
    }];
}

-(void)checkGesturePage:(WXModuleCallback)callback{
    [HMUnlockView showUnlockViewWithType:YWUnlockViewUnlock callBack:^(BOOL result) {
        if(callback){
            if(result){
                callback(@"success");
            }else{
                callback(@"fail");
            }
        }
    }];
}


@end
