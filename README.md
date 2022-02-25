# barthybot

### Latest update: v2.1

- Add `/meme`, `/hehehehaw`, and `/squiward` commands
- Fix bot login after breaking JDA API update to `5.0.0-alpha.8`

### What is barthybot?

Simple, lightweight Discord bot that is a bot replica of Barthy (Isaac).

### Usage

Clone, `./gradlew shadowjar`, and run.

### Contribution

Branch from **master** and submit a pull request.

Make sure to:

1. **DO NOT WORK/COMMIT DIRECTLY ON THE MASTER BRANCH!** Checkout, make a local branch, create a PR.
2. **DO NOT COMMIT YOUR DISCORD BOT TOKEN!** (Discord will automatically deactivate the token.)
3. Update the Procfile with appropriate version number.
4. Do not upload the bot token; use environment variables.
5. Make clear in your PR what you're adding.

### Todo

- [ ] Use JDA RestAction `#queueAfter()` to automate Barthy
- [ ] Similar project, create a `/busjump` command that will automate Shivani's "don't jump out of commuter north" notifs at a specific time
- [ ] ^ create a solid util for task schedulers (kotlin?)
- [ ] `/sudo` allow users with specific permissions to sudo barthy's speech
- [ ] `/meme` has hardcoded code that needs to be dynamic
- [ ] **(Separate project)** Music player
