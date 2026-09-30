# Jono Full V2

This is the complete starter structure for the Jono social-network app. It contains Android + Firebase rules/config templates + Admin Panel + Cloud Functions starter.

## Before building
1. Create a Firebase project.
2. Enable Authentication (Email/Password), Firestore and Storage.
3. Download your Android `google-services.json` and place it at `app/google-services.json`.
4. Deploy/test Firestore and Storage rules from `/firebase`.
5. For admin access, use Firebase Admin SDK to set the custom claim `{admin:true}` for the admin UID.
6. Build the Android app in Android Studio/another compatible Gradle environment.

## Important
The ZIP does not contain `google-services.json` because that file belongs to your Firebase project. Do not share Firebase service-account private keys or other secrets.

## Current Android implementation
- Jono Home Feed UI
- Login
- Register + user document creation
- Create Post + Firestore write
- Firebase Auth/Firestore/Storage/Messaging dependencies
- Firebase security rule templates

## Next production modules
Stories, Reels, real-time Messenger, Friends/Follow, Groups, Pages, notifications, moderation, verification workflow, subscriptions/payments, App Check, pagination and full Admin CRUD need to be implemented and tested against your Firebase project.
