import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

import '../widgets/button.dart';
import '../widgets/card.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    appBar(height) => PreferredSize(
          preferredSize: Size(MediaQuery.of(context).size.width, height + 80),
          child: Stack(
            children: <Widget>[
              Container(
                // Background
                color: Theme.of(context).primaryColor,
                height: height + 75,
                width: MediaQuery.of(context).size.width, // Background
                child: const Center(
                  child: Text(
                    "Home",
                    style: TextStyle(
                        fontSize: 25.0,
                        fontWeight: FontWeight.w600,
                        color: Colors.white),
                  ),
                ),
              ),

              Container(), // Required some widget in between to float AppBar

              Positioned(
                // To take AppBar Size only
                top: 100.0,
                left: 20.0,
                right: 20.0,
                child: AppBar(
                  backgroundColor: Colors.white,
                  leading: Icon(
                    Icons.menu,
                    color: Theme.of(context).primaryColor,
                  ),
                  primary: false,
                  title: const TextField(
                      decoration: InputDecoration(
                          hintText: "Search",
                          border: InputBorder.none,
                          hintStyle: TextStyle(color: Colors.grey))),
                  actions: <Widget>[
                    IconButton(
                      icon: Icon(Icons.search,
                          color: Theme.of(context).primaryColor),
                      onPressed: () {},
                    ),
                    IconButton(
                      icon: Icon(Icons.notifications,
                          color: Theme.of(context).primaryColor),
                      onPressed: () {},
                    )
                  ],
                ),
              )
            ],
          ),
        );

    return Scaffold(
      appBar: appBar(AppBar().preferredSize.height),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text("Validação de presença",
                style: TextStyle(fontSize: 20, fontWeight: FontWeight.w600)),
            Padding(
              padding: const EdgeInsets.only(top: 8, bottom: 8),
              child: Button(
                  text: "Navegar para dashboard",
                  onPressed: () {
                    context.go("/dashboard");
                  }),
            ),
            const Text("Cards",
                style: TextStyle(fontSize: 20, fontWeight: FontWeight.w600)),
            SizedBox(
              height: 200,
              child: ListView.separated(
                separatorBuilder: (BuildContext context, int index) {
                  return const SizedBox(width: 10);
                },
                scrollDirection: Axis.horizontal,
                shrinkWrap: true,
                itemCount: 3,
                itemBuilder: (context, index) {
                  return const AppCard(text: "Teste");
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}
